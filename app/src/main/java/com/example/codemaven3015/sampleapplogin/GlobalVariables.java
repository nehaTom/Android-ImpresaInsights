package com.example.codemaven3015.sampleapplogin;

import android.app.Application;
import android.database.Cursor;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by CodeMaven3015 on 11/6/2017.
 */

public class GlobalVariables extends Application {
    private Cursor Question;
    //private int radioInputTextCheck = 0;
    private Cursor section;
    private int sectionCount = 0;
    private int questionCount;
    private int questionCounter = 0;
    private String clientId = "new";
    private JSONArray answer = new JSONArray() ;
//    public void setRadioInputTextCheck(int i){
//        radioInputTextCheck = i;
//    }
//    public void setRadioInputTextCheckToZero(){
//        radioInputTextCheck = 0;
//    }
//    public int getRadioInputTextCheck(){
//        return radioInputTextCheck;
//    }
    public void resetAllGlobalVariable(){
        sectionCount = 0;
        questionCounter = 0;
       //radioInputTextCheck=0;
        answer = new JSONArray();
        //Question = null;
    }
    public void resetquestioncounter(){
        questionCounter = 0;
        //radioInputTextCheck = 0;
    }
    public void setClientId(String id){
        clientId = id;
    }
    public String getClientId(){
        return clientId;
    }
    public void updateAtAnswer(int i,String ans,String queId,String radio){
        JSONObject obj = new JSONObject();

        try {
            if(ans.equals("")){
                ans = answer.getJSONObject(i).getString("answer");
            }
            obj.put("answer",ans);
            obj.put("question_no",queId);
            obj.put("radio",radio);
            answer.put(i,obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public JSONArray getAnswer(){
        return answer;
    }
    public String getAnswerByQuestionOrder(String order) throws JSONException {
        for(int i =0;i<answer.length();i++){
            JSONObject obj = answer.getJSONObject(i);
            if(order.equals(obj.getString("order"))){
                return (obj.getString("answer"));
            }

        }
        return "";
    }
    public void addAnswerInJsonArray(JSONObject obj){
        answer.put(obj);
    }
    public GlobalVariables(){
        Log.e("INSIDE","CLASS constructor");
    }
    public void setsectionList(Cursor sectionList){
        section = sectionList;
    }
    public Cursor getSectionList(){
        return section;
    }
    public int incrementSectionCount(){
        return sectionCount++;
    }
    public int decrementSectionCount(){
        return sectionCount--;
    }
    public int getSectionCount(){
        return sectionCount;
    }
    public void setGlobalCursor(Cursor csr){
        Question = csr;
        questionCount = csr.getCount();
        Log.e("Inside","global setData"+questionCount);

    }
    public int getCount(){
        return questionCount;
    }
    public int getCounter(){
        Log.e("GET_COUNT",questionCounter+"");
        return questionCounter;
    }
    public void setQuestionCounter(){
        questionCounter = questionCount;
    }
    public int countIncrement(){
        questionCounter++;
        Log.e("GLOBAL INCREMENT",questionCounter+"");
        return questionCounter;
    }
    public int countDecrement(){
        questionCounter--;
        Log.e("GLOBAL DECREMENT",questionCounter+"");
        return questionCounter;
    }
    public Cursor getQuestionCursor(){
        Log.e("Inside","getData");
        return Question;
    }
}


