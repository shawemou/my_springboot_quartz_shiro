package com.jszbtb.ContentManagement.shrioService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.jszbtb.ContentManagement.mapper.ModleMapper;
import com.jszbtb.ContentManagement.mapper.ModleRoleMapper;
import com.jszbtb.ContentManagement.mapper.UserMapper;
import com.jszbtb.ContentManagement.mapper.UserRoleMapper;
import com.jszbtb.ContentManagement.pojo.Modle;
import com.jszbtb.ContentManagement.pojo.ModleRole;
import com.jszbtb.ContentManagement.pojo.User;
import com.jszbtb.ContentManagement.pojo.UserRole;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private ModleRoleMapper modleRoleMapper;
	
	@Autowired
	private ModleMapper modleMapper;
	

	/*@Autowired
	private HttpServletRequest request;*/
	
	

	public List<User> getUser() {
		List<User> userList = this.mapper.selectAll();
		return userList;
	}

/*	public boolean login(User user) {
		User user1 = this.mapper.selectOne(user);
		if(user1!=null){
			request.getSession().setAttribute("user", user1);
			return true;
		}else{
			return false;
		}
	}*/
	
	
	public User shirologin(User user) {
		User user2 = new User();
		user2.setName(user.getName());
		User user1 = this.mapper.selectOne(user2);
		return user1;
	}
	

	/*public List<Modle> getUserModle() {
		User user = (User) request.getSession().getAttribute("user");
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getId());
		List<UserRole> userRoleList = this.userRoleMapper.select(userRole);
		
		ArrayList<Object> roleIds = new ArrayList<Object>();
		for (UserRole user_role : userRoleList) {
			roleIds.add(user_role.getRoleId());
		}
		
		Example example = new Example(ModleRole.class);
		Criteria criteria = example.createCriteria();
		criteria.andIn("roleId", roleIds);
		List<ModleRole> modleRoles = modleRoleMapper.selectByExample(example);
		
		HashSet<String> modleIds = new HashSet<String>();
		for (ModleRole modle_Role : modleRoles) {
			modleIds.add(modle_Role.getModleId());
		}
		
		
		ArrayList<Modle> modleList = new ArrayList<Modle>();
		for (String string : modleIds) {
			Modle modle = this.modleMapper.selectByPrimaryKey(string);
			modleList.add(modle);
		}
		return modleList;
	}*/

	
	
	
	public List<String> getPermission(User curUser) {
		//User user = (User) request.getSession().getAttribute("user");
		User user = curUser;
		
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getId());
		List<UserRole> userRoleList = this.userRoleMapper.select(userRole);
		
		ArrayList<Object> roleIds = new ArrayList<Object>();
		for (UserRole user_role : userRoleList) {
			roleIds.add(user_role.getRoleId());
		}
		
		Example example = new Example(ModleRole.class);
		Criteria criteria = example.createCriteria();
		criteria.andIn("roleId", roleIds);
		List<ModleRole> modleRoles = modleRoleMapper.selectByExample(example);
		
		HashSet<String> modleIds = new HashSet<String>();
		for (ModleRole modle_Role : modleRoles) {
			modleIds.add(modle_Role.getModleId());
		}
		
		
		ArrayList<Modle> modleList = new ArrayList<Modle>();
		ArrayList<String> modleNameList = new ArrayList<String>();
		
		for (String string : modleIds) {
			Modle modle = this.modleMapper.selectByPrimaryKey(string);
			modleList.add(modle);
			modleNameList.add(modle.getName());
		}
		
		return modleNameList;
	}
}
