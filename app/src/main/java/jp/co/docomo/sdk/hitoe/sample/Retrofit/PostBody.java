package jp.co.docomo.sdk.hitoe.sample.Retrofit;

import android.util.Log;

public class PostBody {
    String name;
    int RRI;

    PostBody(String _name){
        this.name = _name;
    }



    public void setBody(String _name){
        Log.d("PostBody","setBody");
        this.name = _name;
    }

//    PostBody(String _name,int _RRI){
//        this.name = _name;

    //    }
//
    public void setBody(String _name,int _RRI){
        Log.d("PostBody","setBody");
        this.name = _name;
        this.RRI = _RRI;
    }

}

