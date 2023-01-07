package com.example.npkapp.utils;

import android.util.Log;

import com.example.npkapp.data.Detail;
import com.example.npkapp.data.DetailCase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

public class FirebaseConnection {
    private static FirebaseConnection instance;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private Map<String, Detail> alphValues = new HashMap<>();
    private Map<String, Detail> numValues = new HashMap<>();
    private Map<String, DetailCase> caseValues = new HashMap<>();
    private Map<String, DetailCase> diffValues = new HashMap<>();

    private FirebaseConnection(){
    }

    public void initAlphabetValues() {
        db.collection("alphabet")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            alphValues.put(document.getId(), document.toObject(Detail.class));
                            Log.d("npkapp", document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.d("npkapp", "Error getting documents: ", task.getException());
                    }
                });
        Log.d("npkappp", db.toString());
    }
    public void initNumberValues(){
        db.collection("numbers")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            numValues.put(document.getId(), document.toObject(Detail.class));
                            Log.d("npkapp", document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.d("npkapp", "Error getting documents: ", task.getException());
                    }
                });
        Log.d("npkappp", db.toString());
    }
    public void initCaseValues(){
        db.collection("cases")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            caseValues.put(document.getId(), document.toObject(DetailCase.class));
                            Log.d("npkapp", document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.d("npkapp", "Error getting documents: ", task.getException());
                    }
                });
        Log.d("npkappp", db.toString());
    }
    public void initDiffValues(){
        db.collection("difftongs")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            diffValues.put(document.getId(), document.toObject(DetailCase.class));
                            Log.d("npkapp", document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.d("npkapp", "Error getting documents: ", task.getException());
                    }
                });
        Log.d("npkappp", db.toString());
    }

    public static FirebaseConnection getInstance(){
        if(instance == null){
            instance = new FirebaseConnection();
        }
        return instance;
    }

    public Detail alphGetByIndex(int index){
        if(alphValues.containsKey(Integer.toString(index))){
            return alphValues.get(Integer.toString(index));
        }
        return null;
    }
    public Detail numGetByIndex(int index){
        if(numValues.containsKey(Integer.toString(index))){
            return numValues.get(Integer.toString(index));
        }
        return null;
    }
    public DetailCase caseGetByIndex(int index){
        if(caseValues.containsKey(Integer.toString(index))){
            return caseValues.get(Integer.toString(index));
        }
        return null;
    }
    public DetailCase diffGetByIndex(int index){
        if(diffValues.containsKey(Integer.toString(index))){
            return diffValues.get(Integer.toString(index));
        }
        return null;
    }
}
