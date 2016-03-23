package com.myself.dao;



import com.myself.model.BlogInfo;

public interface BlogInfoDao {
    public boolean  update(BlogInfo blogInfo);
    public BlogInfo find(BlogInfo blogInfo);
    public boolean save(BlogInfo blogInfo);
    public boolean firm(BlogInfo blogInfo);
}
