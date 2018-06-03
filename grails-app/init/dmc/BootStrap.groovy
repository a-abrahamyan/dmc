package dmc

import com.lifesoft.dmc.auth.Role
import com.lifesoft.dmc.auth.User
import com.lifesoft.dmc.auth.UserRole


class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        def role = Role.findByAuthority('ROLE_USER')?: new Role('ROLE_USER').save()

        def user = User.findByUsername('superuser')?: new User('superuser', springSecurityService.encodePassword('a.321')).save()

        if (!user.authorities.contains(role)) {
            UserRole.create user, role
        }
    }

    def destroy = {
    }
}
