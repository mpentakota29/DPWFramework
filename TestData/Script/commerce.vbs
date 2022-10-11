Set WshShell = WScript.CreateObject("WScript.Shell")
WshShell.SendKeys WshShell.CurrentDirectory & "\TestData\IMG\commerce.png"
WshShell.SendKeys "{ENTER}"