package integration;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.service.AccountingService;


@Path("/account")
public class ApplicationEndPoint {

	@Inject
	private AccountingService repo;
	
	
	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getAllAccounts()
	{
		return repo.getAllAccounts();
	}
	
	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addAccount(String account)
	{
		return repo.addAccount(account);
	}
	public void setRepo(AccountingService repo) {
		this.repo = repo;
	}
}
