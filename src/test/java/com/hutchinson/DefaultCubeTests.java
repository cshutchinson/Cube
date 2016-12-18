package com.hutchinson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultCubeTests {

    @Autowired
    private CubeService cubeService;

    @Before public void initialize() {
    }

	@Test
	public void returns_anInitializedCube() {
		Cube cube = new Cube();

		assertEquals(cube.getTop(), "000000000");
		assertEquals(cube.getLeft(), "111111111");
		assertEquals(cube.getRight(), "222222222");
		assertEquals(cube.getFront(), "333333333");
		assertEquals(cube.getBottom(), "444444444");
		assertEquals(cube.getBack(), "555555555");
	}

	@Test
	public void returns_aCubeBuiltFromFaces() {
		ArrayList<String> faces = new ArrayList<>(
				asList(
						"000000000",
						"111111111",
						"222222222",
						"333333333",
						"444444444",
						"555555555"
				));
		Cube cube = new Cube(faces);

		assertEquals(cube.getTop(), "000000000");
		assertEquals(cube.getLeft(), "111111111");
		assertEquals(cube.getRight(), "222222222");
		assertEquals(cube.getFront(), "333333333");
		assertEquals(cube.getBottom(), "444444444");
		assertEquals(cube.getBack(), "555555555");
	}

	@Test
	public void rotate_top_cw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "0", "0");
		ArrayList<String> result = new ArrayList<>(Arrays.asList(
                "000000000",
                "333111111",
                "555222222",
                "222333333",
                "444444444",
                "111555555"
        ));

		Cube expected = new Cube(result);
		assertEquals(expected,actual);
	}

	@Test
	public void rotate_top_ccw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "0", "1");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"000000000",
				"555111111",
				"333222222",
				"111333333",
				"444444444",
				"222555555"
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_left_cw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "1", "0");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"500500500", //top
				"111111111", //left
				"222222222", //right
				"033033033", //front
				"344344344", //bottom
				"554554554" //back
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_left_ccw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "1", "1");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"300300300", //top
				"111111111", //left
				"222222222", //right
				"433433433", //front
				"544544544", //bottom
				"550550550" //back
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_right_cw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "2", "0");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"003003003", //top
				"111111111", //left
				"222222222", //right
				"334334334", //front
				"445445445", //bottom
				"055055055" //back
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_right_ccw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "2", "1");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"005005005",
				"111111111",
				"222222222",
				"330330330",
				"443443443",
				"455455455"
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_front_cw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "3", "0");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"000000111",
				"114114114",
				"022022022",
				"333333333",
				"222444444",
				"555555555"
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_front_ccw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "3", "1");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"000000222",
				"110110110",
				"422422422",
				"333333333",
				"111444444",
				"555555555"
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_bottom_cw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "4", "0");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"000000000",
				"111111555",
				"222222333",
				"333333111",
				"444444444",
				"555555222"
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_bottom_ccw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "4", "1");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"000000000",
				"111111333",
				"222222555",
				"333333222",
				"444444444",
				"555555111"
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_back_cw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "5", "0");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"222000000",
				"011011011",
				"224224224",
				"333333333",
				"444444111",
				"555555555"
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_back_ccw_returnsAnUpdatedCube() {
		Cube actual = cubeService.rotate(new Cube(), "5", "1");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"111000000",
				"411411411",
				"220220220",
				"333333333",
				"444444222",
				"555555555"
		));

		Cube expected = new Cube(result);
		assertEquals(expected, actual);
	}

	@Test
	public void rotate_left_ccw_and_cw_returnsAnUpdatedCube() {
		Cube cubeStepOne = cubeService.rotate(new Cube(), "1", "0");
		Cube cubeStepTwo = cubeService.rotate(cubeStepOne, "1", "1");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"000000000", //top
				"111111111", //left
				"222222222", //right
				"333333333", //front
				"444444444", //bottom
				"555555555" //back
		));
		Cube expected = new Cube(result);
		assertEquals(expected, cubeStepTwo);
	}

	@Test
	public void rotate_disjointTop_returnsAnUpdatedCube() {
		Cube cubeStepOne = cubeService.rotate(new Cube(), "1", "1");
		Cube cubeStepTwo = cubeService.rotate(cubeStepOne, "0", "1");
		Cube cubeStepThree = cubeService.rotate(cubeStepTwo, "1", "0");
		Cube cubeStepFour = cubeService.rotate(cubeStepThree, "0", "0");

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
				"200300300", //top
				"011115110", //left
				"225222222", //right
				"433033333", //front
				"144444444", //bottom
				"115555555" //back
		));

		Cube expected = new Cube(result);
		assertEquals(expected, cubeStepFour);
	}
}