package sn.sonatel.dsi.dif.springwskeystore.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import sn.sonatel.dsi.dif.springwskeystore.wsdl.GetTeamRequest;
import sn.sonatel.dsi.dif.springwskeystore.wsdl.GetTeamResponse;

/**
 * @author podisto
 * @since
 */
public class TeamClient extends WebServiceGatewaySupport {
    public GetTeamResponse getTeamByCountryCode(String countryCode) {
        GetTeamRequest request = new GetTeamRequest();
        request.setCountryCode(countryCode);
        return (GetTeamResponse) getWebServiceTemplate().marshalSendAndReceive(request);

    }
}
