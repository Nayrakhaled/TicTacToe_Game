///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
///**
// *
// * @author AM STORE
// */
//public class AvialableListController {
//
//    ArrayList<String> playerOnline;
//
//    public ArrayList<String> getPlayerOnline(String message) {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        playerOnline = new ArrayList<>();
//
//                        System.out.println("player onlin11111111111111111e");
//
//                        JSONObject jSONObject = new JSONObject(message);
//                        JSONArray array = jSONObject.getJSONArray("AvaliableList");
//
//                        for (int i = 0; i < array.length(); i++) {
//                            // get field value from JSON Array  
//                            System.out.println(array.get(i));
//                            playerOnline.add((String) array.get(i));
//                            new ListController(playerOnline);
//
//                        }
//                    } catch (JSONException ex) {
//                        Logger.getLogger(AvialableListController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                }
//            }
//        });
//        return playerOnline;
//    }
//}
