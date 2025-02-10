/**
 * ==========================================================
 * Projet de fin d'études - SourceMind
 *
 * Développé par l'équipe Groupe 1 :
 *  - Alpha Amadou DIALLO (https://github.com/alpha947)
 *    Email : dialloalphaamadou947@gmail.com
 *  - Kouloube KOLIE (https://github.com/kouloube)
 *    Email : kouloubekolie@gmail.com
 *  - Moussa CAMARA (https://github.com/usermoussa)
 *    Email : moussaccamaraa@gmail.com
 *  - Mohamed Mouctar KABA (https://github.com/Mokaba-lab)
 *    Email : mocktarkba@gmail.com
 *
 * Ce projet Spring Boot a été conçu et développé
 * pour démontrer nos compétences techniques et
 * apporter une solution innovante.
 * ==========================================================
 */
package com.sourcemind.pfe.istock.core.params;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageParam {
	private int pageNumber = 1;
	private int pageSize = 10;
	private int totalPages;
	private long totalElements;
	private Sort sort;

	public PageParam(int pageNumber, int pageSize, int totalPages, long totalElements) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}

	public static <T, U> PageSearchResult<T> toPageSearchResult(T list, Page<U> page) {
		PageParam param = new PageParam();
		param.setPageNumber(page.getPageable().getPageNumber() + 1);
		param.setPageSize(page.getPageable().getPageSize());
		param.setTotalPages(page.getTotalPages());
		param.setTotalElements(page.getTotalElements());
		return new PageSearchResult<>(new PageParam().fromPage(page), list);
	}

	public Pageable toPageable() {
		return PageRequest.of(pageNumber - 1, pageSize);
	}

	public PageParam fromPage(Page<?> page) {
		PageParam param = new PageParam();
		param.setPageNumber(page.getPageable().getPageNumber() + 1);
		param.setPageSize(page.getPageable().getPageSize());
		param.setTotalPages(page.getTotalPages());
		param.setTotalElements(page.getTotalElements());
		return param;
	}

}