package br.com.project.dao.impl;

import br.com.project.dao.GenericDAOImpl;
import br.com.project.dao.IUserDAO;
import br.com.project.models.User;

public class UserDAOImpl extends GenericDAOImpl<User> implements IUserDAO<User> {

	private static final long serialVersionUID = 4302022412345327839L;

    public UserDAOImpl() {
        super(User.class);
    }
	
}
