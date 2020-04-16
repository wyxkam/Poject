package cn.config.service;

import cn.pojo.TbPermission;
import cn.pojo.TbUser;
import cn.service.TbPermissionService;
import cn.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TbPermissionService PermissionService;

    @Autowired
    private TbUserService UserService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser=UserService.getUserByUsername(username);
        if (null==tbUser){
            throw new UsernameNotFoundException("username: "+username+" is not exist !");
        }
        List<GrantedAuthority> authorities=new ArrayList<>();
        List<TbPermission> permissions=PermissionService.getByUserid(tbUser.getId());
        permissions.forEach(permission -> {
            authorities.add(new SimpleGrantedAuthority(permission.getEname()));
        });
        return new User(tbUser.getUsername(),tbUser.getPassword(),authorities);
    }
}
