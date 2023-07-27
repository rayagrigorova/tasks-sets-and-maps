<h1 align="center">Задачи</h1>

## 9. Задачи

1. Напишете програма, която показва броя гласни и съгласни в текстов файл. Използвайте множество за съхранение на гласните A, E, I, O и U.
2. **По желание** Редактирайте CountKeywords класа, така че ключовите думи, които са в кавички (част от стринг) или част от коментар да не се добавят към броя на ключовите думи.

## 10. Задачи

1. Напишете програма за съхраняване на двойки държава - столица в речник. Вашата програма трябва да пита потребителя да въведе столица за дадена държава и да проверява дали отговорът е верен или не.
- Направете програмата като игра. Отчитайте точки на потребителя за верен отговор и му отнемайте за грешен.
2. **По желание** Пренапишете CountKeyWords.java, за да прочетете във файл с изходен код на Java и да преброите честотата на поява на всяка ключова дума във файла.
3. **По желание** Пренапишете CountOccurrenceOfWords.java, за да покажете думите във възходящ ред на броя на срещане.
Съвет: Създайте клас с име WordOccurrence, който имплементира Comparable интерфейс. Класът трябва да съдържа две полета: дума и брой срещания. Методът compareTo трябва да сравнява броя срещания. За всяка двойка в хеш речника създайте обект от WordOccurrence и го съхранете в ArrayList. Сортирайте списъка с метода Collections.sort.