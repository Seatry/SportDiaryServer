package com.example.SportDiaryServer.service.conversion;

import com.example.SportDiaryServer.dto.EditDto;
import com.example.SportDiaryServer.entity.editEntity.Edit;
import com.example.SportDiaryServer.entity.editEntity.Time;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityDtoConversionService {
    private final ModelMapper modelMapper;

    @Autowired
    public EntityDtoConversionService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EditDto convertEntityToDto(Edit edit) {
        return modelMapper.map(edit, EditDto.class);
    }

    public Time convertDtoToEntity(EditDto editDto) {
        return modelMapper.map(editDto, Time.class);
    }

}
