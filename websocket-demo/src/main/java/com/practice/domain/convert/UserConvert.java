package com.practice.domain.convert;

import com.practice.domain.model.dto.UserDTO;
import com.practice.infrastructure.po.User;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2023/6/25 19:42
 */
@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface UserConvert {

	List<User> userDTOToPOList(List<UserDTO> users);

	User userDTOToPO(UserDTO user);
}
