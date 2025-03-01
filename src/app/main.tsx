import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { App } from "./app.tsx";
import { QueryClientProvider } from "@tanstack/react-query";
import { queryClient } from "@/shared/constants/query.ts";
import "./styles/index.css";

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <QueryClientProvider client={queryClient}>
            <App />
        </QueryClientProvider>
    </StrictMode>
);
