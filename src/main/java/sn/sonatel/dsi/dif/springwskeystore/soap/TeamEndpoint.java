package sn.sonatel.dsi.dif.springwskeystore.soap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sn.sonatel.dsi.dif.springwskeystore.repository.TeamRepository;
import sn.sonatel.dsi.dif.springwskeystore.wsdl.GetTeamRequest;
import sn.sonatel.dsi.dif.springwskeystore.wsdl.GetTeamResponse;

/**
 * @author podisto
 * @since
 */
@Endpoint
@Slf4j
public class TeamEndpoint {
    private static final String NAMESPACE_URI = "http://www.uefa.com/uefaeuro/season=2016/teams";
    private final TeamRepository teamRepository;

    public TeamEndpoint(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTeamRequest")
    @ResponsePayload
    public GetTeamResponse getTeam(@RequestPayload GetTeamRequest request) {
        log.info("GetTeamRequest: {} ", request);
        GetTeamResponse response = new GetTeamResponse();
        sn.sonatel.dsi.dif.springwskeystore.wsdl.Team team = teamRepository.findByCountryCode(request.getCountryCode());
        response.setTeam(team);
        log.info("GetTeamResponse: {} ", response);
        return response;
    }
}
