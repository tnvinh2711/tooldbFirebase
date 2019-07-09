package com.zinzin.tooluploaddb.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.zinzin.tooluploaddb.R;
import com.zinzin.tooluploaddb.model.AutoChess.ClassList;
import com.zinzin.tooluploaddb.model.AutoChess.Creep;
import com.zinzin.tooluploaddb.model.AutoChess.Item;
import com.zinzin.tooluploaddb.model.AutoChess.RaceList;
import com.zinzin.tooluploaddb.model.AutoChess.SetImage;
import com.zinzin.tooluploaddb.model.AutoChess.Units;
import com.zinzin.tooluploaddb.model.teamFightTatics.Unit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AutoChessFragment extends Fragment {
    private String stringClasslist, stringUnitlist, stringRacelist, stringItemlist, stringCreeplist;
    private List<Units> unitsList = new ArrayList<>();
    private List<RaceList> raceList = new ArrayList<>();
    private List<ClassList> classList = new ArrayList<>();
    private List<Creep> creepList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    int idItem = 0;
    int idCreep = 0;

    public static AutoChessFragment newInstance() {
        return new AutoChessFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        Button btnUpload = view.findViewById(R.id.btn_upload);
        btnUpload.setText("upload auto chess");
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseHtml();
            }
        });
        return view;
    }

    private void parseHtml() {
        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("autochess");
        myRef.child("download").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (ds.getKey() != null) {
                        switch (ds.getKey()) {
                            case "classlist":
                                stringClasslist = ds.getValue(String.class);
                                break;
                            case "creeplist":
                                stringCreeplist = ds.getValue(String.class);
                                break;
                            case "itemlist":
                                stringItemlist = ds.getValue(String.class);
                                break;
                            case "racelist":
                                stringRacelist = ds.getValue(String.class);
                                break;
                            case "unitlist":
                                stringUnitlist = ds.getValue(String.class);
                                break;
                        }
                    }
                }
                final StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
                raceList = SetImage.fullRaceList(stringRacelist);
                for(final RaceList races: raceList){
                    Uri imageUri = Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/"+races.getImgRace());
                    StorageReference riversRef = mStorageRef.child("race/"+races.getName()+".png");
                    riversRef.putFile(imageUri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    // Get a URL to the uploaded content
                                    taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            Log.e("tessttt",uri.toString());
                                            races.setImgRace(uri.toString());
                                            myRef.child("upload").child("raceList").child(races.getName()).setValue(races);
                                        }
                                    });

                                }
                            });
                }
                classList =  SetImage.fullClassList(stringClasslist);
                for(final ClassList classL: classList){
                    Uri imageUri = Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/"+classL.getImgClass());
                    StorageReference riversRef = mStorageRef.child("class/"+classL.getName()+".png");
                    riversRef.putFile(imageUri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    // Get a URL to the uploaded content
                                    taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            Log.e("tessttt",uri.toString());
                                            classL.setImgClass(uri.toString());
                                            myRef.child("upload").child("classList").child(classL.getName()).setValue(classL);
                                        }
                                    });

                                }
                            });
                }
                creepList = SetImage.fullCreepList(stringCreeplist);
                itemList = SetImage.fullItemList(stringItemlist);
                for(final Item item: itemList){
                    Uri imageUri = Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/"+item.getImgItem());
                    StorageReference riversRef = mStorageRef.child("item/"+item.getName()+".png");
                    riversRef.putFile(imageUri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    // Get a URL to the uploaded content
                                    taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            Log.e("tessttt",uri.toString());
                                            item.setUrlItem(uri.toString());
                                            item.setId(idItem);
                                            idItem++;
                                            myRef.child("upload").child("itemList").child(String.valueOf(item.getId())).setValue(item);

                                        }
                                    });

                                }
                            });
                }
                unitsList = SetImage.fullUnitsList(stringUnitlist);
                for(final Units units: unitsList){
                    Uri imageUriFull = Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/"+units.getFull_image());
                    final Uri imageUriMini = Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/"+units.getMini_image());
                    final Uri imageUriAva = Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/"+units.getIcon_image());
                    final Uri imageUriSkill = Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/"+units.getSkill_image());
                    StorageReference fullRef = mStorageRef.child("unit/"+units.getName()+"f.png");
                    final StorageReference miniRef = mStorageRef.child("unit/"+units.getName()+"m.png");
                    final StorageReference avaRef = mStorageRef.child("unit/"+units.getName()+"a.png");
                    final StorageReference skillRef = mStorageRef.child("unit/"+units.getName()+"s.png");
                    fullRef.putFile(imageUriFull)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    // Get a URL to the uploaded content
                                    taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            Log.e("tessttt",uri.toString());
                                            units.setUrl_full_image(uri.toString());
                                            miniRef.putFile(imageUriMini)
                                                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                        @Override
                                                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                            // Get a URL to the uploaded content
                                                            taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                @Override
                                                                public void onSuccess(Uri uri) {
                                                                    Log.e("tessttt",uri.toString());
                                                                    units.setUrl_mini_image(uri.toString());
                                                                    avaRef.putFile(imageUriAva)
                                                                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                                @Override
                                                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                                    // Get a URL to the uploaded content
                                                                                    taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                                        @Override
                                                                                        public void onSuccess(Uri uri) {
                                                                                            Log.e("tessttt",uri.toString());
                                                                                            units.setUrl_icon_image(uri.toString());
                                                                                            skillRef.putFile(imageUriSkill)
                                                                                                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                                                        @Override
                                                                                                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                                                            // Get a URL to the uploaded content
                                                                                                            taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                                                                @Override
                                                                                                                public void onSuccess(Uri uri) {
                                                                                                                    Log.e("tessttt",uri.toString());
                                                                                                                    units.setUrl_skill_image(uri.toString());
                                                                                                                    myRef.child("upload").child("unitList").child(units.getName()).setValue(units);
                                                                                                                }
                                                                                                            });

                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });

                                                                                }
                                                                            });
                                                                }
                                                            });

                                                        }
                                                    });
                                        }
                                    });

                                }
                            });

                }
                myRef.child("upload").child("creepList").removeValue();
                for (Creep creep : creepList) {
                    creep.setId(idCreep);
                    idCreep++;
                    myRef.child("upload").child("creepList").child(String.valueOf(creep.getId())).setValue(creep);
                }

                Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
