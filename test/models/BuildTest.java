package models;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class BuildTest {

	@Test
	public void callGetBuilds() {
		List<Build> builds;
		try {
			builds = Build.GetBuilds();
			assertThat(builds.size() == 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
