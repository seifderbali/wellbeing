package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.Forum;
import tn.esprit.repositories.ForumRepository;
import tn.esprit.repositories.SwearRepository;

@Slf4j
@Service
public class ForumService implements IForumService{


@Autowired 
ForumRepository forumReposiory;
SwearRepository Sr;


@Override
public List<Forum> retreiveAllForums() {
	List<Forum> listForums = new ArrayList<Forum>();
	try {
		listForums = (List<Forum>) forumReposiory.findAll();
		for(Forum f : listForums)
		{
			log.info("user = "+f);
		}}
		catch(Exception e)
		{
			log.info("error = "+e);
		}
	 
		return listForums;
}

@Override
public Forum addForum(Forum f) {
	try
	{
	forumReposiory.save(f);
	}
	catch(Exception e)
	{
		 log.info("error = "+e);
	}
	return f;
}

@Override
public void deleteForum(long id) {
	try{
	//	Long idl = Long.parseLong(id);
		forumReposiory.deleteById(id);
		}
		catch(Exception e)
		{
			log.info("error = "+e);
		}	
}

@Override
public Forum updateForum(Forum f) {
	try
	{
	forumReposiory.save(f);
	}
	catch(Exception e)
	{
		log.info("error = "+e);
	}
	return f;
}

@Override
public Forum retrieveForum(long id) {
	Forum f = new Forum();
	try{
	 f = forumReposiory.findById(id).get();
		}
	catch(Exception e)
	{
		log.info("error = "+e);
	}
	return f ;
   }

@Override
public List<Forum> searchForums(String keyword) {
	List<Forum> listForums = new ArrayList<Forum>();
	try {
		listForums = (List<Forum>) forumReposiory.search(keyword);
		for(Forum f : listForums)
		{
			log.info("user = "+f);
		}}
		catch(Exception e)
		{
			log.info("error = "+e);
		}
	 
		return listForums;
}


@Override
public int swearAction(String ch) {
	List<String> swearList = listswears();
    int i=0;
    
    while(i < swearList.size() ){
    
        if (ch.contains((swearList.get(i)))==true){
            return 1;               
        }
        i++;
    }
    
    return 0;     
}

@Override
public List<String> listswears() {
		List<String> listSwears = new ArrayList<String>();
		
			listSwears =forumReposiory.listSwear();
			
			return listSwears;
	
}

@Override
public int stats(int id) {
	return forumReposiory.nbcomment(id);
}
/*
@Override
public int viral(int id) {
	return forumReposiory.viral(id);
}

*/


}
