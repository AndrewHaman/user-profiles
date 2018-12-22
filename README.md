# mssql
                                                                                                                               
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Deceadmin1!' -p 1433:1433 -d mcr.microsoft.com/mssql/server:2017-latest

To Delete ALL contaianers:

docker ps -aq | xargs -n 1 docker rm

