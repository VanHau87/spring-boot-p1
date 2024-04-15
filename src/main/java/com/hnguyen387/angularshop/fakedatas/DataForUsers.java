package com.hnguyen387.angularshop.fakedatas;

import java.util.Arrays;
import java.util.List;

import com.hnguyen387.angularshop.dtos.UserDTO;

public class DataForUsers {
	public static List<UserDTO> allUsers() {
		List<UserDTO> users = Arrays.asList(
				new UserDTO(1, "1245-456-789"),
				new UserDTO(2, "1345-456-789"),
				new UserDTO(3, "1545-456-789"),
				new UserDTO(4, "1245-556-789"),
				new UserDTO(5, "1245-456-779"),
				new UserDTO(6, "8245-456-789"),
				new UserDTO(7, "1285-456-789")
			);
		return users;
	}
}
