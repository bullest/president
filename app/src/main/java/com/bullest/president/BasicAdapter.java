package com.bullest.president;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.animation.BaseAnimation;

import java.util.List;

/**
 * Created by yunfezhang on 3/26/18.
 */

public abstract class BasicAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    protected Context mContext;
    protected List<T>mData;
    protected int mItemViewId;//item布局id
    protected View mHeaderView;
    protected View mFooterView;

    public BasicAdapter(int itemViewId, @Nullable List<T> data, Context context) {
        super(itemViewId, data);
        this.mItemViewId = itemViewId;
        this.mContext = context;
        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, T t) {
        initView(viewHolder,t);
        initData(viewHolder,t);
        setListener(viewHolder,t);
    }

    protected abstract void initView(BaseViewHolder viewHolder, T t);
    protected abstract void initData(BaseViewHolder viewHolder, T t);
    protected abstract void setListener(BaseViewHolder viewHolder, T t);

    /**获取position，当添加有header或footer要注意改变**/
    public int getPosition(BaseViewHolder viewHolder){
        return viewHolder.getLayoutPosition();
    }

    /**获取headerView**/
    protected View getHeaderView(int headerViewId) {
        if(mContext!=null){
            mHeaderView=LayoutInflater.from(mContext).inflate(headerViewId, null);
        }
        return mHeaderView;
    }

    /**获取footerView**/
    protected View getFooterView(int footerViewId) {
        if (mContext != null&&mFooterView==null) {
            mFooterView = LayoutInflater.from(mContext).inflate(footerViewId, null);
        }
        return mFooterView;
    }

    /**添加headerView**/
    public void addHeaderView(int headerViewId){
        addHeaderView(getHeaderView(headerViewId));
    };

    /**添加footerView**/
    public void addFooterView(int footerViewId){
        addFooterView(getFooterView(footerViewId));
    }

    /**设置RecyclerView**/
    public void setRecyclerManager(RecyclerView recyclerView){
        LinearLayoutManager layoutManager=new LinearLayoutManager(mContext);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this);
        openLoadAnimation();//默认adapter渐现效果
    }

    /**adapter渐现动画**/
    public void openAlphaAnimation(){
        openLoadAnimation(BaseQuickAdapter.ALPHAIN);
    }

    /**adapter缩放动画**/
    public void openScaleAnimation(){
        openLoadAnimation(BaseQuickAdapter.SCALEIN );
    }

    /**adapter从下到上动画**/
    public void openBottomAnimation(){
        openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM  );
    }

    /**adapter从左到右动画**/
    public void openLeftAnimation(){
        openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT   );
    }

    /**adapter从右到左动画**/
    public void openRightAnimation(){
        openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT    );
    }

    /**自定义动画**/
    public void openLoadAnimation(BaseAnimation animation){

    }

}
