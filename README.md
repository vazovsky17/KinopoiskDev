<h2>Catalog version</h2>
В проекте используется каталог версий, все общие библиотеки и версии хранятся с помощью него.
Каталог расположен в файле <i>gradle/libs.version.toml</i>

<h2>Стек</h2>
<ul>
  <li>Kotlin</li>
  <li>Dagger Hilt</li>
  <li>Retrofit</li>
  <li>Room (в процессе)</li>
  <li>Navigation Component</li>
  <li>Glide, Lottie</li>
  <li>Timber, Chucker</li>
</ul>

<h2>Архитектура</h2>
MVVM
<h3>Слои</h3>
<ul>
  <li>data слой
  <ul>
    <li>Источники данных - сеть, бд</li>
    <li>Repository - реализуют получение и маппинг данных из источников. К источникам данных можно обращаться только из репозиториев.</li>
  </ul>
  </li>
  <li>domain слой
  <ul>
    <li>UseCase - законченная бизнес логика. Может содержать в себе репозитории и другие юзкейсы. Вся логика происходит здесь.</li>
  </ul>
  </li>
  <li>di слой
  <ul>
    <li>DatabaseModule - для подключения базы данных Room (в процессе)</li>
    <li>ApiServiceModule - для подключения к API Kinopoisk.dev</li>
    <li>RepositoryModule - для привязки репозиториев</li>
  </ul>
  </li>
  <li>presentation слой
  <ul>
    <li>Fragment - просто view, только отрисовывает, не содержит логики.</li>
    <li>ViewModel - содержит логику формирования view, содержит в себе любое количество UseCase. Не может содержать репозитории и источники данных.</li>
  </ul>
  </li>
</ul>

<h2>Chucker</h2>
К проекту подключен Chucker, позволяющий отслеживать запросы к API

<h2>Database</h2>
В процессе
