package com.aichat.domain.user.mapper;

import com.aichat.domain.user.dto.request.UserRequest;
import com.aichat.domain.user.dto.response.UserResponse;
import com.aichat.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // Spring Bean으로 등록
public interface UserMapper {

  // User Entity -> UserResponse DTO 변환
  UserResponse toResponse(User user);

  // UserRequest DTO -> User Entity 변환
  @Mapping(target = "password", source = "encodedPassword")
  User toEntity(UserRequest request, String encodedPassword);
}
