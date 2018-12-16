package sn.sonatel.dsi.dif.springwskeystore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author podisto
 * @since
 */
@Getter
@Setter
@ToString
public class Team implements Serializable {
    private String countryCode;
    private String country;
    private String nickName;
    private String coach;
}
