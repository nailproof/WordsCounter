# WordsCounter
Данная программа подсчитывает количество уникальных слов в html-файле и сортирует их количество в порядке убывания.
Использовалась сторонняя библиотека для чтения и дальнейшей записи html-файла без тегов (org.jsoup.Jsoup) в цикле while c 21 по 28 строку:
while ((line = reader.readLine()) != null) {
                Document doc = Jsoup.parse(line);
                String lineWithoutTags = doc.body().text();
                    wordsArray = lineWithoutTags.split("\\s*(\\s|!|\\?|-|—|«|»|:|;|/|\\(|\\)|\\[|\\]|\\.|\t|\r|\n)\\s*");
                for (int i = 0; i < wordsArray.length; i++) {
                    wordsList.add(wordsArray[i].trim());
                }
            }
В данной программе слова "дом" и "Дом" будут считаться двумя разными словами.
Используется один метод readFile, в котором осуществляется чтение html-файла, построчная запись текста (при помощи цикла while) в массив (массив уникальных слов String[] wordsArray), 
также при помощи цикла, данный массив инициализируется заново с каждой новой строкой чтения файла, с каждой итерацией цикла for запись данных из массива ведется в список wordsList.
Затем из списка информация записывается в HashMap<String,Integer> wordsCounter (где и проводится подсчёт уникальных слов).
В заключении, проводится сортировка по количетсву повторений (по значениям Map) и перезапись информации в новый HashMap<String, Integer> orderedMap.
