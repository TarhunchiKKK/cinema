import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { App } from "./app.tsx";
import { QueryClientProvider } from "@tanstack/react-query";
import { queryClient } from "./query/query-client.ts";
import { ThemeProvider } from "@/features/dark-mode/index.ts";
import "./styles/index.css";

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <QueryClientProvider client={queryClient}>
            <ThemeProvider>
                <App />
            </ThemeProvider>
        </QueryClientProvider>
    </StrictMode>
);
