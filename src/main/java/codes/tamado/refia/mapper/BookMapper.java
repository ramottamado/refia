package codes.tamado.refia.mapper;

import codes.tamado.refia.dto.BookDto;
import codes.tamado.refia.entity.Book;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface BookMapper {
  @Mapping(source = "publisherName", target = "publisher.name")
  @Mapping(source = "categoryName", target = "category.name")
  Book toEntity(BookDto bookDto);

  @InheritInverseConfiguration(name = "toEntity")
  BookDto toDto(Book book);

  @InheritConfiguration(name = "toEntity")
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Book partialUpdate(BookDto bookDto, @MappingTarget Book book);
}