package eu.glowacki.utp.assignment10.repositories.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.repositories.GroupRepository;
import eu.glowacki.utp.assignment10.repositories.IGroupRepository;

public class GroupRepositoryTest extends RepositoryTestBase<GroupDTO, IGroupRepository> {

	@Test
	public void add() {
		
		GroupDTO gr1 = new GroupDTO(1, "EDEK", "Strategical busness");
		GroupDTO gr2 = new GroupDTO(2, "IDA", "Databases");
		repository().add(gr1);
		repository().add(gr2);
		Assert.assertEquals(2, repository().getCount());
	}

	@Test
	public void update() {
		GroupDTO gr2 = new GroupDTO(2, "IDA", "Databases");
		repository().add(gr2);
		Assert.assertEquals(1, repository().getCount());
		gr2.setName("EDA");
		repository().update(gr2);
		Assert.assertEquals(1, repository().getCount());
	}
	
	@Test
	public void addOrUpdate() {
		GroupDTO gr2 = new GroupDTO(2, "IDA", "Databases");
		repository().add(gr2);
		Assert.assertEquals(1, repository().getCount());
		repository().addOrUpdate(gr2);
		Assert.assertEquals(1, repository().getCount());
	}

	@Test
	public void delete() {
		GroupDTO gr2 = new GroupDTO(2, "IDA", "Databases");
		repository().add(gr2);
		Assert.assertEquals(1, repository().getCount());
		repository().delete(gr2);
		Assert.assertEquals(0, repository().getCount());
	}

	@Test
	public void findById() {
		GroupDTO gr1 = new GroupDTO(2, "IDA", "Databases");
		GroupDTO gr2 = new GroupDTO(1, "qwe", "try");
		GroupDTO gr3 = new GroupDTO(3, "LOL", "WOW");
		repository().add(gr1);
		repository().add(gr2);
		repository().add(gr3);
		Assert.assertEquals(3, repository().getCount());
		Assert.assertEquals(gr2, repository().findById(2));
	}
	
	@Test
	public void findByName() {
		GroupDTO gr1 = new GroupDTO(2, "IDA", "Databases");
		GroupDTO gr2 = new GroupDTO(1, "qwe", "try");
		GroupDTO gr3 = new GroupDTO(3, "IDA", "WOW");
		
		repository().add(gr1);
		repository().add(gr2);
		repository().add(gr3);
		List<GroupDTO> l =repository().findByName("IDA");
		Assert.assertEquals(3, repository().getCount());
		Assert.assertEquals(2, l.size());
	}

	@Override
	protected IGroupRepository Create() {
		return new GroupRepository();
	}
}