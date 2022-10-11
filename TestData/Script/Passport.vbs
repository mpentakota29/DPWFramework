Set WshShell = WScript.CreateObject("WScript.Shell")
WshShell.SendKeys WshShell.CurrentDirectory & "\TestData\IMG\Passport.png"
WshShell.SendKeys "{ENTER}"