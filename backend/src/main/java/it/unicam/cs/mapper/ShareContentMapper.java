package it.unicam.cs.mapper;

import it.unicam.cs.dto.ShareContentDTO;
import it.unicam.cs.model.ShareContent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShareContentMapper {
    public ShareContentDTO toDTO(ShareContent shareContent);
    public ShareContent toEntity(ShareContentDTO dto);
}
