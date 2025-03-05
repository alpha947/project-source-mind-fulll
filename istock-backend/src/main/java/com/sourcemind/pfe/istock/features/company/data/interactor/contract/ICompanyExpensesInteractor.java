package com.sourcemind.pfe.istock.features.company.data.interactor.contract;
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
import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyExpensesRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyExpensesSearchRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Aworo James
 * @since 5/10/23
 */
public interface ICompanyExpensesInteractor {

	ResponseEntity<CompanyExpensesRequest> save(CompanyExpensesRequest request);
	
	ResponseEntity<PageSearchResult<List<CompanyExpensesRequest>>> search(PageSearchRequest<CompanyExpensesSearchRequest> request);
}