package com.farwolf.weex.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengjiangrong on 2017/8/17.
 */

public class TabFragment extends Fragment {

    public List<String> urls=new ArrayList<>();

    public FragmentTabHost tabhost;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(v!=null)
            return v;
        v=inflater.inflate( com.farwolf.libary.R.layout.api_multifragment_host_fragment	, null);
        tabhost=(FragmentTabHost)v.findViewById(android.R.id.tabhost);
        tabhost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);



        for(String q:urls)
        {
            Bundle args = new Bundle();
            args.putString("url", q);
            tabhost.addTab(tabhost.newTabSpec(urls.indexOf(q)+"tag").setIndicator("1"), WeexFragment.class, args);
        }
        return v;
    }

    public void setIndex(int index)
    {
        tabhost.setCurrentTab(index);
    }

    public TabFragment()
    {
//        List<String> l=new ArrayList<String>();
//        l.add("app/busi/tab/movie.js");
//        l.add("app/busi/tab/serial.js");
//        for(String q:urls)
//        {
//            Intent in=new Intent(getContext(),WeexFragment_.class);
//            in.putExtra("url",q);
//            this.add(urls.indexOf(q)+"tag",in);
//        }
//        add(WeexFragment_.class);
    }


    public void init() {

//        urls.add("app/busi/tab/movie.js");
//        urls.add("app/busi/tab/serial.js");
//        for(String q:urls)
//        {
//            Intent in=new Intent(getContext(),WeexFragment_.class);
//            in.putExtra("url",q);
//            add(WeexFragment_.class);
//            this.add(urls.indexOf(q)+"tag",in);
//        }

    }
}
