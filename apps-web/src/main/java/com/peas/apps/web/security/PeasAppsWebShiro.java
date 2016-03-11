/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.apps.web.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * @author Lijq 2016年3月11日上午10:18:32
 * @since version 1.0
 */
@Service
public class PeasAppsWebShiro extends AuthorizingRealm {

	/**
	 * 权限验证
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// 获取登录时输入的用户名
		String username = (String) principals.fromRealm(getName()).iterator().next();

		// TODO 到数据库查询是否有此对象
		// 在这里写伪代码，不连接数据库

		if (StringUtils.isNoneBlank(username) && username.equals("lijingyi")) {

			// 权限信息对象 info，用来存放查出的用户的所有角色 role 及 权限 permission
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

			// 用户的角色集合
			// TODO 同样是伪代码
			Set<String> roles = new HashSet<String>();
			roles.add("admin");
			roles.add("system");
			info.setRoles(roles);

			// 用户的角色所对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
			/*
			 * List<Role> roleList=user.getRoleList(); for (Role role :
			 * roleList) { info.addStringPermissions(role.getPermissionsName());
			 * }
			 */

			return info;

		}
		return null;
	}

	/**
	 * 登陆认证
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.
	 * apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {

		// UsernamePasswordToken 对象用来存放提交的登陆信息
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		// 查出是否有此用户
		// User user = service.getByUsername(token.getUsername());
		// TODO 伪代码
		if (StringUtils.isNoneBlank(token.getUsername()) && token.getUsername().equals("lijingyi")) {
			// 若存在，将此用户存放到登陆认证info中
			return new SimpleAuthenticationInfo(token.getUsername(), "password", getName());
		}

		return null;
	}

}
