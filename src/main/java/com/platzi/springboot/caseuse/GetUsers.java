package com.platzi.springboot.caseuse;

import com.platzi.springboot.domain.UserDomain;

import java.util.List;

public interface GetUsers {
    List<UserDomain> find();
}