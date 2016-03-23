package com.myself.dao;

import java.util.List;

import com.myself.model.Blog;
import com.myself.model.BlogAll;

public interface BlogDao {
    public boolean saveOrUpdate(Blog blog,String nickName);
    public List<Blog> query(Blog blog);
    public List<BlogAll> query();
    public BlogAll query(int id);
    public List<Blog> query(String nickName,String title);
 
}
