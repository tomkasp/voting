import pl.certa.Authority
import pl.certa.Person
import pl.certa.PersonAuthority

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        if (!Person.count()) {
            createData()
        }
    }

    def destroy = {
    }

    private void createData() {
        def userRole = new Authority(authority: 'ROLE_USER').save()

        String password = 'a'

        [jeff: 'Jeff Brown', graeme: 'Graeme Rocher', burt: 'Burt Beckwith', peter: 'Peter Ledbrook'].each { userName, realName ->
            def user = new Person(username: userName, realName: realName, password: password, enabled: true).save()
            PersonAuthority.create user, userRole, true
        }
    }
}
