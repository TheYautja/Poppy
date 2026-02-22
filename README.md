# Poppy

Poppy is a multithreaded terminal emulator built in Java, using pty4j to interface with the Linux pseudo-terminal.

![Poppy terminal emulator](https://github.com/user-attachments/assets/05203a12-5ba8-42e1-915a-05677499166e)

## Running

From the project root:

```bash
mvn clean compile exec:java
```

## Notes
 - Uses a real shell via /dev/pts, not command emulation
 - requires Java 17+
