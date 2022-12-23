package lt.codeacademy.invoice.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.codeacademy.invoice.entities.Role;
import lt.codeacademy.invoice.repositories.RoleRepository;


@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getRoleList() {
		var list = roleRepository.findAll();
		//System.out.println(list);
		return list;
	}
	
	public Role addRole(Role role) {
		
		System.out.println(role + " servisas");
		
		try{
			
			Role inv = roleRepository.save(role );
			System.out.println(inv);
			return inv;
		}	catch(Exception e) {
			System.out.println(e.getMessage() + "Suluzo cia");
		}
		
		return null;
	}

	public Role getRoleById(Long id) {
		Optional<Role> role = roleRepository.findById( id );

		if (role.isEmpty()) {
			return null;
		}

		return role.get();
	}

	public Role updateRoleById(Long id, Role role) {
		return roleRepository.save( role );
	}

	public String deleteRoleById(Long id) {
		boolean exists = roleRepository.existsById( id );

		if (exists) {
			roleRepository.deleteById( id );
			return "Role was deleted with id: " + id;
		}
		return "Role does not exist";
	}
}
