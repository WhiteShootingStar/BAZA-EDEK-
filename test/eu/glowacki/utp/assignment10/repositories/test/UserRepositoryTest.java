package eu.glowacki.utp.assignment10.repositories.test;

import org.junit.Before;
import org.junit.Test;

import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.UserDTO;
import eu.glowacki.utp.assignment10.repositories.IUserRepository;
import eu.glowacki.utp.assignment10.repositories.UserRepository;

import java.util.List;

import org.junit.Assert;

public final class UserRepositoryTest extends RepositoryTestBase<UserDTO, IUserRepository> {

//	@Before
//	public void create() {
//		
//		guy4 = new UserDTO(4, "Pog", "CD");
//		guy5 = new UserDTO(5, null, null);
//	}

	@Test
	public void add() {
		UserDTO guy1 = new UserDTO(1, "admin", "admin");
		UserDTO guy2 = new UserDTO(2, "Pog", "Champ");
		UserDTO guy3= new UserDTO(3 , "PEPE", "Ga");

		repository().add(guy1);
		repository().add(guy2);
		repository().add(guy3);
	Assert.assertEquals(3, repository().getCount());
	}

	@Test
	public void update() {
		UserDTO guy4 = new UserDTO(4, "Pog", "CD");
//		guy5 = new UserDTO(5, null, null);
		repository().add(guy4);
		guy4.setPassword("OMEGALUL");
		repository().update(guy4);
	
	}

	@Test
	public void addOrUpdate() {
		UserDTO guy1 = new UserDTO(1, "admin", "admin");
		UserDTO guy2 = new UserDTO(2, "Pog", "Champ");
		UserDTO guy3= new UserDTO(3 , "PEPE", "Ga");
		repository().addOrUpdate(guy2);
		Assert.assertEquals(1,repository().getCount());
		repository().addOrUpdate(guy2);
		Assert.assertEquals(1, repository().getCount());

	}

	@Test
	public void delete() {
		UserDTO guy3= new UserDTO(3 , "PEPE", "Ga");
		repository().add(guy3);
		Assert.assertEquals(1, repository().getCount());
		repository().delete(guy3);
		Assert.assertEquals(0, repository().getCount());
		
	}

	@Test
	public void findById() {
		UserDTO guy1 = new UserDTO(1, "admin", "admin");
		UserDTO guy2 = new UserDTO(2, "Pog", "Champ");
		UserDTO guy3= new UserDTO(3 , "PEPE", "Ga");
		repository().add(guy1);
		Assert.assertEquals(1, repository().getCount());
		UserDTO temp =repository().findById(1);
		Assert.assertEquals(guy1, temp);
	
	}

	@Test
	public void findByName() {
		UserDTO guy1 = new UserDTO(1, "admin", "admin");
		UserDTO guy2 = new UserDTO(2, "Pog", "Champ");
		UserDTO guy3= new UserDTO(3 , "PEPE", "Ga");
		UserDTO guy4 = new UserDTO(4, "Pog", "CD");
		repository().add(guy2);
		repository().add(guy4);
		Assert.assertEquals(2,repository().getCount());
		List<UserDTO> l =repository().findByName("Pog");
		Assert.assertEquals(2, l.size());
		
	}

	@Override
	protected IUserRepository Create() {
		//throw new UnimplementedException();
		return new UserRepository();
	}
}