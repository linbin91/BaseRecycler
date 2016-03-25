package com.linbin.baserecycler.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.linbin.baserecycler.R;
import com.linbin.baserecycler.base.BaseRecyclerAdapter;
import com.linbin.baserecycler.base.BaseRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private BaseRecyclerAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mDatas = new ArrayList<String>();

        for (int i = 'A'; i <= 'z'; i++){
            mDatas.add("" + (char)i);
        }

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        adapter =new BaseRecyclerAdapter<String>(MainActivity.this, mDatas, false,layoutManager ) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
                //ImageView imageView = holder.getImageView(R.id.content);
                holder.getTextView(R.id.content).setText(mDatas.get(position));
            }
        };
        adapter.setData(mDatas);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
    }
}
