package celine_amireux.com.vn.CelineBE.services.impl;

import celine_amireux.com.vn.CelineBE.dao.UserDao;
import celine_amireux.com.vn.CelineBE.dao.impl.UserDaoImpl;
import celine_amireux.com.vn.CelineBE.model.User;
import celine_amireux.com.vn.CelineBE.services.UserService;

import java.io.File;
import java.util.List;



public class UserServiceImpl implements UserService {
    UserDao userDao =  new UserDaoImpl();

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void edit(User newUser) {
        User oldUser = userDao.get(newUser.getId());

        oldUser.setEmail(newUser.getEmail());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setRoleId(newUser.getRoleId());
        if (newUser.getAvatar() != null) {
            // XOA ANH CU DI
            String fileName = oldUser.getAvatar();
            final String dir = "E:\\upload";
            File file = new File(dir + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }
            // THEM ANH MOI
            oldUser.setAvatar(newUser.getAvatar());
        }

        userDao.edit(oldUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> search(String username) {
        return userDao.search(username);
    }

    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }

        return null;
    }

    @Override
    public User loginAdmin(String email, String password) {
        User user = this.get(email);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }

        return null;
    }

    @Override
    public boolean register(String username, String password, String email) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        userDao.insert(new User(email, username, password));
        return true;
    }


    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }
}
