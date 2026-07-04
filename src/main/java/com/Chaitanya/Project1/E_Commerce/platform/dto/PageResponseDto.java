package com.Chaitanya.Project1.E_Commerce.platform.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponseDto<T> {
private List<T> content;
private int pageNumber;
private int pageSize;
private Long totalElement;
private int totalPages;
private boolean last;

}
