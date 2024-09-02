package com.ntnn;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.util.HashMap;
import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.bodyString;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.pause;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class TransactionSimulation extends Simulation {

  String bodyReq = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
      "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.07\">\n" +
      "    <FIToFICstmrCdtTrf>\n" +
      "        <GrpHdr>\n" +
      "            <MsgId>42E1037861BE4EF9BDF0CE57B4ECB083</MsgId>\n" +
      "            <CreDtTm>2018-01-01T01:00:00.000+07:00</CreDtTm>\n" +
      "            <NbOfTxs>1</NbOfTxs>\n" +
      "            <SttlmInf>\n" +
      "                <SttlmMtd>INDA</SttlmMtd>\n" +
      "            </SttlmInf>\n" +
      "        </GrpHdr>\n" +
      "        <CdtTrfTxInf>\n" +
      "            <PmtId>\n" +
      "                <EndToEndId>42E1037861BE4EF9BDF0CE57B4ECB083-1</EndToEndId>\n" +
      "                <TxId>FA4A4F894C7943A896F4673B1D9714F5</TxId>\n" +
      "            </PmtId>\n" +
      "            <IntrBkSttlmAmt Ccy=\"IDR\">10000</IntrBkSttlmAmt>\n" +
      "            <ChrgBr>DEBT</ChrgBr>\n" +
      "            <Dbtr>\n" +
      "                <Nm>Hardi</Nm>\n" +
      "                <Id>\n" +
      "                    <PrvtId>\n" +
      "                        <Othr>\n" +
      "                            <Id>1234567890123456</Id>\n" +
      "                            <SchmeNm>\n" +
      "                                <Prtry>NIK</Prtry>\n" +
      "                            </SchmeNm>\n" +
      "                        </Othr>\n" +
      "                    </PrvtId>\n" +
      "                </Id>\n" +
      "            </Dbtr>\n" +
      "            <DbtrAcct>\n" +
      "                <Id>\n" +
      "                    <Othr>\n" +
      "                        <Id>0987654321</Id>\n" +
      "                        <SchmeNm>\n" +
      "                            <Prtry>ACCOUNT_ID</Prtry>\n" +
      "                        </SchmeNm>\n" +
      "                    </Othr>\n" +
      "                </Id>\n" +
      "            </DbtrAcct>\n" +
      "            <DbtrAgt>\n" +
      "                <FinInstnId>\n" +
      "                    <BICFI>CENAIDJAXXX</BICFI>\n" +
      "                    <ClrSysMmbId>\n" +
      "                        <MmbId>BCA</MmbId>\n" +
      "                    </ClrSysMmbId>\n" +
      "                </FinInstnId>\n" +
      "            </DbtrAgt>\n" +
      "            <CdtrAgt>\n" +
      "                <FinInstnId>\n" +
      "                    <Othr>\n" +
      "                        <Id>NUSAPAY</Id>\n" +
      "                    </Othr>\n" +
      "                </FinInstnId>\n" +
      "            </CdtrAgt>\n" +
      "            <Cdtr>\n" +
      "                <Nm>Hardi</Nm>\n" +
      "                <Id>\n" +
      "                    <PrvtId>\n" +
      "                        <Othr>\n" +
      "                            <Id>1234567890123456</Id>\n" +
      "                            <SchmeNm>\n" +
      "                                <Prtry>NIK</Prtry>\n" +
      "                            </SchmeNm>\n" +
      "                        </Othr>\n" +
      "                    </PrvtId>\n" +
      "                </Id>\n" +
      "            </Cdtr>\n" +
      "            <CdtrAcct>\n" +
      "                <Id>\n" +
      "                    <Othr>\n" +
      "                        <Id>081808347561</Id>\n" +
      "                        <SchmeNm>\n" +
      "                            <Prtry>ACCOUNT_ID</Prtry>\n" +
      "                        </SchmeNm>\n" +
      "                    </Othr>\n" +
      "                </Id>\n" +
      "            </CdtrAcct>\n" +
      "        </CdtTrfTxInf>\n" +
      "    </FIToFICstmrCdtTrf>\n" +
      "</Document>";

  Map<String, String> headers = new HashMap<>();

  public Map<String, String> getHeaders() {
    headers.put("Authorization", "Bearer ZDBjMmE3N2YtODY5Ni00NDU5LThmMzItZjI3MTZhOGE2YmE5");
    headers.put("Content-Type", "application/xml");
    return headers;
  }

  ChainBuilder keyExchange = exec(
      http("Transaction").post("/client/transaction/topup/0987654321")
          .headers(getHeaders())
          .body(StringBody(bodyReq))
              .check(status().is(200)),
      pause(1)
  );

  HttpProtocolBuilder httpProtocol = http.baseUrl("http://localhost:8092")
          .acceptHeader("text/html,application/xhtml+xml,application/json,application/xml;q=0.9,*/*;q=0.8")
          .acceptLanguageHeader("en-US,en;q=0.5")
          .acceptEncodingHeader("gzip, deflate")
          .userAgentHeader(
              "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/119.0"
          );

  ScenarioBuilder transaction = scenario("Transaction").exec(keyExchange);

  {
    setUp(
        transaction.injectOpen(rampUsers(2400).during(120))
    ).protocols(httpProtocol);
  }
}