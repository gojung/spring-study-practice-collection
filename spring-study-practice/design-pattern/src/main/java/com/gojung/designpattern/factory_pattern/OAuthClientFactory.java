package com.gojung.designpattern.factory_pattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class OAuthClientFactory {

  private final Map<OAuthType, OAuthClient> oAuthClientMap = new HashMap<>();

  //  생성자 주입
  public OAuthClientFactory(List<OAuthClient> oAuthClients) throws IllegalAccessException {
    if(CollectionUtils.isEmpty(oAuthClientMap)){
      throw new IllegalAccessException("oAuthClient가 하나도 없읍니다");
    }
    for(OAuthClient oAuthClient : oAuthClients){
      this.oAuthClientMap.put(oAuthClient.getOAuthType(), oAuthClient);
    }
  }

  /**
   * Enum으로 Client를 끌어온다
   * @param oAuthType
   * @return
   */
  public OAuthClient getClient(OAuthType oAuthType){
    return oAuthClientMap.get(oAuthType);
  }

  /**
   * Enum에 해당하는 Client 인증처리
   * @param oAuthType
   */
  public void authorization(OAuthType oAuthType){
    OAuthClient client = getClient(oAuthType);
    client.authorization();
  }

}
