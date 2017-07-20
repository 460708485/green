
package com.wang.green.common.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wang.green.domain.Result;
import com.wang.green.domain.User;
import com.wang.green.service.UserService;

/**
 * @author wangjq
 *
 */
public class MyRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

	protected boolean permissionsLookupEnabled = false;

	@Resource
	private UserService sysUserService;

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String account = upToken.getUsername();	//
//		String password = EncryptUtil.md5(String.valueOf(upToken.getPassword()));

		// Null username is invalid
		if (account == null) {
			throw new AccountException("用户名不能为空.");
		}

		SimpleAuthenticationInfo info = null;

		String password = getPasswordForUser(account)[0];

		info = new SimpleAuthenticationInfo(account, password.toCharArray(), getName());

		return info;
	}

	private String[] getPasswordForUser(String account) {
		try {
			User user = new User();
			Result result = sysUserService.findByCondition(account);
			List<User> users = (List<User>)result.getData();
			
			if(CollectionUtils.isNotEmpty(users) && 1==users.size()) {
				user = users.get(0);
			}
			else {//如果通过账号密码得到超过1个用户或者没有匹配的用户则当用户异常处理
				throw new AccountException("用户名不存在.");
			}
			return new String[]{user.getPassword()};
		} catch (Exception e) {
			throw new AccountException("用户名不存在.");
		}
	}

	/**
	 * This implementation of the interface expects the principals collection to
	 * return a String username keyed off of this realm's {@link #getName()
	 * name}
	 *
	 * @see #getAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// null usernames are invalid
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
		}

		//String username = (String) getAvailablePrincipal(principals);

		/*Set<String> roleNames = getRoleNamesForUser();
		Set<String> permissions = getPermissions();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);*/
//		return info;
		return null;
	}

	/*protected Set<String> getRoleNamesForUser() {
		Set<String> roleSet = new HashSet<String>();
		roleSet.add(MySecurityUtils.getUserRole().getCode());
		return roleSet;
	}

	protected Set<String> getPermissions() {
		final Set<String> menuUrlSet = MySecurityUtils.getSysMenuDTOList().stream().map(rm -> {
				return rm.getMenuUrl();
			}).collect(Collectors.toSet());
		return menuUrlSet;
	}
*/
}
