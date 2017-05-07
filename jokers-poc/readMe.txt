Tutorial para criação das filas:
http://www.oracle.com/webfolder/technetwork/tutorials/obe/fmw/wls/12c/08-JMS--4468/jms.htm

Job: 1009
Nome da Connection Factory: settlementFinancialAdjustmentCF
Nome da fila: settlementFinancialAdjustmentQueue

Job: 1010
Nome da Connection Factory: settlementFinancialMovementGeneratorCF
Nome da fila: settlementFinancialMovementGeneratorQueue

Datasource:
bob.datasource

Localização do arquivo a ser consumido pelo processo 1009:
C:/tmp/testData.csv