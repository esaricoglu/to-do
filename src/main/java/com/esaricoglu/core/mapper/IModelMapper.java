package com.esaricoglu.core.mapper;

import org.modelmapper.ModelMapper;

public interface IModelMapper {

    ModelMapper forResponse();

    ModelMapper forRequest();
}
