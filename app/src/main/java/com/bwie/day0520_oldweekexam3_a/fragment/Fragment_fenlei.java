package com.bwie.day0520_oldweekexam3_a.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.alibaba.fastjson.JSON;
import com.bwie.day0520_oldweekexam3_a.R;
import com.bwie.day0520_oldweekexam3_a.adapter.ExpandableAdapter;
import com.bwie.day0520_oldweekexam3_a.bean.FenLei;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by
 * Chenxin
 * on 2017/5/20.
 */

public class Fragment_fenlei extends Fragment {

    private ExpandableListView el;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fenlei, container, false);

        el = (ExpandableListView) view.findViewById(R.id.el);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        executeData();

        el.setGroupIndicator(null);

    }

    public void executeData(){

        RequestParams params = new RequestParams("http://www.meirixue.com/api.php?c=category&a=getall");

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {//成功的回调

                List<FenLei> fenLeis = JSON.parseArray(result, FenLei.class);

                ExpandableAdapter adapter = new ExpandableAdapter(getActivity(),fenLeis);

                el.setAdapter(adapter);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {//失败的回调

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
