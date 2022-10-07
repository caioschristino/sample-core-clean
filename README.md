# CoreClean Guideline Codestyle
CoreClean é um framework para guiar desenvolvedores Android's na construção de ```Fragments```, ```Activitys```, ```ViewModels``` e ```Caso de Uso```. Baseado em arquitetura limpa e construído pela v2.softwarehouse. Com o propósito de colaborar com a comunidade Android.

# O que ele faz?
- Guia seu desenvolvimento Android.

- Guia seu desenvolvimento de test unitário.

- Capaz de processar casos de usos unitários, encadeados ou coleção.

- Capaz de processar guarda no caso de uso.

- Possui canais de despacho semânticos.

- Convive pacificamente com legados.

# O que ele não faz?
- Define organização do projeto.

- Define estratégia de injeção de dependencia.

- Define estratégia de tests instrumentados.

- Define estratégia de repositorio.

## Sample utlizando o CoreClean

O sample é uma visão de organização de projeto e uso do CoreClean como guia. 

Define estratégia de repositorio e estratégia de injeção de dependencias. Trazendo a camada de ```Plugin``` como destaque.


### Qual papel da camada Plugin?

Respeitando o principio de Liskov. A camada plugin permite a substituibilidade apenas "plugando" uma outra classe concreta que implemente a mesma interface.


### Qual papel da camada Feature?

Resposável por organizar as camadas ```Business```,  ```Domain```, ```Gateway``` e ```View``` por feature.


#### - Subcamada Business

Responsável por conter o(s) caso(s) de uso(s) da feature e uma interface inversão da dependencia. 

No nosso caso, nossa interface será para um repositório.


#### - Subcamada Domain

Responsável por conter um ```objeto``` de dominio da feature.

No nosso caso, ```objeto``` representa tanto um Data Transfer Object(DTO) quanto um ModeView.


#### - Subcamada Gateway

Responsável por inverter a dependencia com a ViewModel. Deixando apenas os contratos com a view expostos no Controller.

No nosso caso, contém uma estrégia de injeção de dependencia por ```Singleton Pattern```. Através da classe ```LandingGatewayInjector```


#### - Subcamada View
Responsável por conter View da feature. No nosso caso, um Fragment.
No nosso caso, contém também uma estrégia de injeção de dependencia por ```Singleton Pattern```. Através da classe ```LandingViewInjector```


## Linguagem, bibliotecas e ferramentas utilizadas no Sample
* [Kotlin](https://kotlinlang.org/)
* [Android Support Libraries](https://developer.android.com/topic/libraries/support-library)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Gson](https://github.com/google/gson)
* [Mockito](http://site.mockito.org/)
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)






## Contato
v2.softwarehouse@gmail.com
